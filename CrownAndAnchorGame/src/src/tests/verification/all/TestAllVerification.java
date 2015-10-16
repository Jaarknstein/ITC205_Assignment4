package tests.verification.all;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import tests.verification.TestBug01Fixed;
import tests.verification.TestBug02Fixed;
import tests.verification.TestBug03Fixed;
import tests.verification.TestBug04Fixed;

@RunWith(Suite.class)
@Suite.SuiteClasses({
   TestBug01Fixed.class,
   TestBug02Fixed.class,
   TestBug03Fixed.class,
   TestBug04Fixed.class
})

public class TestAllVerification {  
	
}  	