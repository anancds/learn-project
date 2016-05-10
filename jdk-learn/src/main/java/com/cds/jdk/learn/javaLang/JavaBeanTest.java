package com.cds.jdk.learn.javaLang;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class JavaBeanTest {
    public static void main(String[] args)
        throws IllegalAccessException, InstantiationException, IntrospectionException,
        InvocationTargetException {
        Class<JavaBeanTestSupport> classTest = JavaBeanTestSupport.class;
        Object obj = classTest.newInstance();
        BeanInfo beanInfo = Introspector.getBeanInfo(classTest);

        PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();

        for (PropertyDescriptor pd : pds) {
            Method setMethod = pd.getWriteMethod();
            Method getMethod = pd.getReadMethod();

            Class<?> properClass = pd.getPropertyType();
            if (properClass == String.class) {
                setMethod.invoke(obj, "abc");
                System.out.println(getMethod.invoke(obj));
            }
            if (properClass == Boolean.class || properClass == boolean.class) {
                setMethod.invoke(obj, true);
                System.out.println(getMethod.invoke(obj));
            } else if (properClass == Double.class || properClass == double.class) {
                setMethod.invoke(obj, 0.01D);
                System.out.println(getMethod.invoke(obj));
            } else if (properClass == int.class || properClass == Integer.class) {
                setMethod.invoke(obj, 100);
                System.out.println(getMethod.invoke(obj));
            }
        }
    }
}
