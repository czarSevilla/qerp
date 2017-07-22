package com.qacg.qerp.persistence;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EntityTester<T> {

	private Logger LOGGER = LoggerFactory.getLogger(EntityTester.class);

	public enum BoolGetter {
		IS, GET
	};

	public static final BoolGetter IS = BoolGetter.IS;

	public static final BoolGetter GET = BoolGetter.GET;

	private T t;

	private BoolGetter boolGetter;

	public EntityTester(Class<T> clazz, BoolGetter boolGetter) {
		LOGGER.info(String.format("Testing %s", clazz));
		try {
			t = clazz.newInstance();
		} catch (IllegalAccessException | InstantiationException ie) {
			LOGGER.error("Can't instanciate Pojo", ie);
		}
		this.boolGetter = boolGetter;
	}

	public void verify() {
		assert t != null;

		Field[] fields = t.getClass().getDeclaredFields();

		for (Field f : fields) {
			if (Modifier.isStatic(f.getModifiers())) {
				continue;
			}
			LOGGER.info(String.format("Verify field %s", f.getName()));
			String n = f.getName();
			String nM = String.format("%s%s", n.substring(0, 1).toUpperCase(), n.substring(1));
			String getter = String.format("get%s", nM);
			String booleanGetter = String.format("is%s", nM);
			String setter = String.format("set%s", nM);

			Object v = null;

			try {
				v = asignedValue(f);
			} catch (IllegalAccessException | InstantiationException ie) {
				LOGGER.error(String.format("Can't asign value from %s", f.getType()), ie);
			}

			invokeSetter(f, setter, v);

			invokeGetter(f, booleanGetter, getter, v);

		}
	}

	private Object asignedValue(Field f) throws IllegalAccessException, InstantiationException {
		if (f.getType().isAssignableFrom(String.class)) {
			return "valor";
		} else if (f.getType().isAssignableFrom(Integer.class) || f.getType().isAssignableFrom(int.class)) {
			return 1;
		} else if (f.getType().isAssignableFrom(Long.class) || f.getType().isAssignableFrom(long.class)) {
			return 1L;
		} else if (f.getType().isAssignableFrom(Float.class) || f.getType().isAssignableFrom(float.class)) {
			return 1.0F;
		} else if (f.getType().isAssignableFrom(Double.class) || f.getType().isAssignableFrom(double.class)) {
			return 1.0D;
		} else if (f.getType().isAssignableFrom(Boolean.class) || f.getType().isAssignableFrom(boolean.class)) {
			return Boolean.TRUE;
		} else if (f.getType().isAssignableFrom(List.class)) {
			return new ArrayList<>();
		} else if (f.getType().isAssignableFrom(Set.class)) {
			return new HashSet<>();
		} else if (f.getType().isAssignableFrom(Map.class)) {
			return new HashMap<>();
		} else if (f.getType().isAssignableFrom(BigDecimal.class)) {
			return BigDecimal.ZERO;
		} else {
			return f.getType().newInstance();
		}
	}

	private void invokeSetter(Field f, String setter, Object v) {
		try {
			LOGGER.debug(String.format("v.class = %s", f.getType()));
			Method methodSet = t.getClass().getDeclaredMethod(setter, f.getType());
			methodSet.invoke(t, v);
		} catch (NoSuchMethodException er) {
			LOGGER.error(String.format("method not found: %s", setter), er);
			assert false;
		} catch (InvocationTargetException | IllegalAccessException ite) {
			LOGGER.error(String.format("can't invoke method: %s with value: %s", setter, v), ite);
			assert false;
		}
	}

	private void invokeGetter(Field f, String booleanGetter, String getter, Object v) {
		Method methodGet = null;
		try {
			if (f.getType() == Boolean.class || f.getType() == boolean.class) {
				if (boolGetter == IS) {
					methodGet = t.getClass().getDeclaredMethod(booleanGetter);
				} else {
					methodGet = t.getClass().getDeclaredMethod(getter);
				}
			} else {
				methodGet = t.getClass().getDeclaredMethod(getter);
			}
			Object r = methodGet.invoke(t);
			assert r != null;
			assert r.equals(v);
		} catch (NoSuchMethodException er) {
			LOGGER.error(String.format("method not found: %s", getter), er);
			assert false;
		} catch (InvocationTargetException | IllegalAccessException ite) {
			LOGGER.error(String.format("can't invoke method: %s with value: %s", methodGet.getName(), v), ite);
			assert false;
		}
	}
}
