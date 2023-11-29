package batchGroupParallelCrossB;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.OTM.GenericUtils.BaseClass;
import com.OTM.GenericUtils.ListenerImplementation;
@Listeners(com.OTM.GenericUtils.ListenerImplementation.class)
public class PracticeTest extends BaseClass{

	
	
	@Test
	public void practice_1() {
		System.out.println("practice 1 test ");
		
		
		System.out.println("practice 2 test ");
		System.out.println("practice 3 test ");
		Assert.fail();
		System.out.println("practice 4 test ");
	
	}
	
	
}
