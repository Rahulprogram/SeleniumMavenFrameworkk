package TestComponents;

import org.apache.commons.io.filefilter.TrueFileFilter;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer
{
    int count=0;
    int maxtry=1;

    @Override
    public boolean retry(ITestResult iTestResult)
    {
        if(count<maxtry)
        {
            count++;
            return true;
        }
        return false;
    }
    }

