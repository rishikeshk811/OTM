package com.OTM.GenericUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.annotations.ITestAnnotation;
import org.testng.internal.annotations.IAnnotationTransformer;

import net.bytebuddy.implementation.bind.MethodDelegationBinder.ParameterBinding.Anonymous;

public class IAnonotaionTransImp implements IAnnotationTransformer{

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod,
			Class<?> occurringClazz) {
		// TODO Auto-generated method stub

annotation.setRetryAnalyzer(com.OTM.GenericUtils.IretryAnalyserImplementation.class);
	
	}

 
}
