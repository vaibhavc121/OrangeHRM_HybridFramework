package listeners;

import annotations.Owner;
import annotations.Reset;
import org.testng.IClassListener;
import org.testng.ITestClass;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.lang.reflect.Method;

public class Listeners implements IClassListener, ITestListener
{

    // === Runs once after all test methods in a class ===
    @Override
    public void onAfterClass(ITestClass testClass)
    {
        for (Method method : testClass.getRealClass().getDeclaredMethods())
        {
            if (method.isAnnotationPresent(Reset.class))
            {
                try
                {
                    Object instance = testClass.getRealClass().getDeclaredConstructor().newInstance();
                    method.setAccessible(true);
                    method.invoke(instance);
                } catch (Exception e)
                {
                    throw new RuntimeException("Failed to invoke @Reset method: " + method.getName(), e);
                }
            }
        }
    }

    // === Runs before each @Test method ===
    @Override
    public void onTestStart(ITestResult result)
    {
        Method method = result.getMethod().getConstructorOrMethod().getMethod();
        if (method.isAnnotationPresent(Owner.class))
        {
            Owner owner = method.getAnnotation(Owner.class);
            System.out.println(">>> Test " + method.getName() + " is owned by: " + owner.value());
        }
    }
}