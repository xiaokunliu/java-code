package com.xiaokunliu.commons.others;

import java.util.Collection;
import java.util.Map;


public final class RequiresUtility {

	/**
	 * 
	 * @param expression
	 */
	public static void isTrue(boolean expression) {
		isTrue(expression, "[Assertion failed] - this expression must be true");
	}

	/**
	 * 
	 * @param expression
	 * @param message
	 */
	public static void isTrue(boolean expression, String message) {
		isTrue(expression, new IllegalArgumentException(message));
	}

	/**
	 * 
	 * @param expression
	 * @param throwIfAssertFail
	 */
	public static void isTrue(boolean expression, RuntimeException throwIfAssertFail) {
		if (!expression) {
			throw throwIfAssertFail;
		}
	}

	/**
	 * 
	 * @param object
	 */
	public static void isNull(Object object) {
		isNull(object, "[Assertion failed] - the object argument must be null");
	}

	/**
	 * 
	 * @param object
	 * @param message
	 */
	public static void isNull(Object object, String message) {
		isNull(object, new IllegalArgumentException(message));
	}

	/**
	 * 
	 * @param object
	 * @param throwIfAssertFail
	 */
	public static void isNull(Object object, RuntimeException throwIfAssertFail) {
		if (object != null) {
			throw throwIfAssertFail;
		}
	}

	/**
	 * 
	 * @param object
	 */
	public static void notNull(Object object) {
		notNull(object, "[Assertion failed] - this argument is required; it must not be null");
	}

	/**
	 * 
	 * @param object
	 * @param message
	 */
	public static void notNull(Object object, String message) {
		notNull(object, new IllegalArgumentException(message));
	}

	/**
	 * 
	 * @param object
	 * @param throwIfAssertFail
	 */
	public static void notNull(Object object, RuntimeException throwIfAssertFail) {
		if (object == null) {
			throw throwIfAssertFail;
		}
	}

	/**
	 * 
	 * @param text
	 */
	public static void hasLength(String text) {
		hasLength(text, "[Assertion failed] - this String argument must have length; it must not be null or empty");
	}

	/**
	 * 
	 * @param text
	 * @param message
	 */
	public static void hasLength(String text, String message) {
		hasLength(text, new IllegalArgumentException(message));
	}

	/**
	 * 
	 * @param text
	 * @param throwIfAssertFail
	 */
	public static void hasLength(String text, RuntimeException throwIfAssertFail) {
		if (!isStringHasLength(text)) {
			throw throwIfAssertFail;
		}
	}

	/**
	 * 
	 * @param text
	 * @return
	 */
	private static boolean isStringHasLength(String text) {
		return null != text && text.length() > 0;
	}

	/**
	 * 
	 * @param text
	 */
	public static void hasText(String text) {
		hasText(text, "[Assertion failed] - this String argument must have text; it must not be null, empty, or blank");
	}

	/**
	 * 
	 * @param text
	 * @param message
	 */
	public static void hasText(String text, String message) {
		hasText(text, new IllegalArgumentException(message));
	}

	/**
	 * 
	 * @param text
	 * @param throwIfAssertFail
	 */
	public static void hasText(String text, RuntimeException throwIfAssertFail) {
		if (!isStringHasText(text)) {
			throw throwIfAssertFail;
		}
	}

	/**
	 * 
	 * @param text
	 * @return
	 */
	private static boolean isStringHasText(String text) {
		if (!isStringHasLength(text)) {
			return false;
		}

		int strLen = text.length();
		for (int i = 0; i < strLen; i++) {
			if (!Character.isWhitespace(text.charAt(i))) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * @param textToSearch
	 * @param substring
	 */
	public static void doesNotContain(String textToSearch, String substring) {
		doesNotContain(textToSearch, substring, "[Assertion failed] - this String argument must not contain the substring [" + substring + "]");
	}

	/**
	 * 
	 * @param textToSearch
	 * @param substring
	 * @param message
	 */
	public static void doesNotContain(String textToSearch, String substring, String message) {
		doesNotContain(textToSearch, substring, new IllegalArgumentException(message));
	}

	/**
	 * 
	 * @param textToSearch
	 * @param substring
	 * @param throwIfAssertFail
	 */
	public static void doesNotContain(String textToSearch, String substring, RuntimeException throwIfAssertFail) {

		if (isStringHasLength(textToSearch) && isStringHasLength(substring) && textToSearch.indexOf(substring) != -1) {

			throw throwIfAssertFail;
		}
	}

	/**
	 * 
	 * @param array
	 */
	public static void notEmpty(Object[] array) {
		notEmpty(array, "[Assertion failed] - this array must not be empty: it must contain at least 1 element");
	}

	/**
	 * 
	 * @param array
	 * @param message
	 */
	public static void notEmpty(Object[] array, String message) {
		notEmpty(array, new IllegalArgumentException(message));
	}

	/**
	 * 
	 * @param array
	 * @param throwIfAssertFail
	 */
	public static void notEmpty(Object[] array, RuntimeException throwIfAssertFail) {

		if (isEmptyArray(array)) {
			throw throwIfAssertFail;
		}
	}

	/**
	 * 
	 * @param array
	 * @return
	 */
	private static boolean isEmptyArray(Object[] array) {
		return null == array || array.length <= 0;
	}

	/**
	 * 
	 * @param array
	 * @param message
	 */
	public static void noNullElements(Object[] array, String message) {
		if (array != null) {
			for (Object element : array) {
				if (element == null) {
					throw new IllegalArgumentException(message);
				}
			}
		}
	}

	/**
	 * 
	 * @param array
	 */
	public static void noNullElements(Object[] array) {
		noNullElements(array, "[Assertion failed] - this array must not contain any null elements");
	}

	/**
	 * 
	 * @param array
	 * @param throwIfAssertFail
	 */
	public static void noNullElements(Object[] array, RuntimeException throwIfAssertFail) {
		if (array != null) {
			for (Object element : array) {
				if (element == null) {
					throw throwIfAssertFail;
				}
			}
		}
	}

	/**
	 * 
	 * @param collection
	 * @param message
	 */
	public static void notEmpty(Collection<?> collection, String message) {
		notEmpty(collection, new IllegalArgumentException(message));
	}

	/**
	 * 
	 * @param collection
	 */
	public static void notEmpty(Collection<?> collection) {
		notEmpty(collection, "[Assertion failed] - this collection must not be empty: it must contain at least 1 element");
	}

	/**
	 * 
	 * @param collection
	 * @param throwIfAssertFail
	 */
	public static void notEmpty(Collection<?> collection, RuntimeException throwIfAssertFail) {
		if (isEmptyCollection(collection)) {
			throw throwIfAssertFail;
		}
	}

	/**
	 * 
	 * @param collection
	 * @return
	 */
	private static boolean isEmptyCollection(Collection<?> collection) {
		return null == collection || collection.isEmpty();
	}

	/**
	 * 
	 * @param map
	 * @param message
	 */
	public static void notEmpty(Map<?, ?> map, String message) {
		notEmpty(map, new IllegalArgumentException(message));
	}

	/**
	 * 
	 * @param map
	 */
	public static void notEmpty(Map<?, ?> map) {
		notEmpty(map, "[Assertion failed] - this map must not be empty; it must contain at least one entry");
	}

	/**
	 * 
	 * @param map
	 * @param throwIfAssertFail
	 */
	public static void notEmpty(Map<?, ?> map, RuntimeException throwIfAssertFail) {
		if (isEmptyMap(map)) {
			throw throwIfAssertFail;
		}
	}

	/**
	 * 
	 * @param map
	 * @return
	 */
	private static boolean isEmptyMap(Map<?, ?> map) {
		return null == map || map.isEmpty();
	}

	/**
	 * 
	 * @param type
	 * @param obj
	 * @param message
	 */
	public static void isInstanceOf(Class<?> type, Object obj, String message) {
		notNull(type, "Type to check against must not be null");
		if (!type.isInstance(obj)) {
			throw new IllegalArgumentException(message + "Object of class [" + (obj != null ? obj.getClass().getName() : "null") + "] must be an instance of " + type);
		}
	}

	/**
	 * 
	 * @param clazz
	 * @param obj
	 */
	public static void isInstanceOf(Class<?> clazz, Object obj) {
		isInstanceOf(clazz, obj, "");
	}

	/**
	 * 
	 * @param type
	 * @param obj
	 * @param throwIfAssertFail
	 */
	public static void isInstanceOf(Class<?> type, Object obj, RuntimeException throwIfAssertFail) {
		notNull(type, "Type to check against must not be null");
		if (!type.isInstance(obj)) {
			throw throwIfAssertFail;
		}
	}

	/**
	 * 
	 * @param superType
	 * @param subType
	 * @param message
	 */
	public static void isAssignable(Class<?> superType, Class<?> subType, String message) {
		notNull(superType, "Type to check against must not be null");
		if (subType == null || !superType.isAssignableFrom(subType)) {
			throw new IllegalArgumentException(message + subType + " is not assignable to " + superType);
		}
	}

	/**
	 * 
	 * @param superType
	 * @param subType
	 */
	public static void isAssignable(Class<?> superType, Class<?> subType) {
		isAssignable(superType, subType, "");
	}

	/**
	 * 
	 * @param expression
	 * @param message
	 */
	public static void state(boolean expression, String message) {
		if (!expression) {
			throw new IllegalStateException(message);
		}
	}

	/**
	 * 
	 * @param expression
	 */
	public static void state(boolean expression) {
		state(expression, "[Assertion failed] - this state invariant must be true");
	}

	private RequiresUtility() {
	}
}
