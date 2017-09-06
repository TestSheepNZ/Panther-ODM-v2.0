package OperationalDataManual;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;



@RunWith(Suite.class)
@SuiteClasses({ AircraftManagementTests.class, 
        FuelRateDataTests.class })
public class TestSuite {

}