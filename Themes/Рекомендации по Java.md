# Рекомендации по Java

01. Упрощение функций с if-ами

Не правильно: 

```
public static boolean isEven(int number) {
	if (number % 2 == 0) {
		return true;
	} else {
		return false;
	}
}
```

Правильно:

```
public static boolean isEven(int number) {
	return number % 2 == 0;
}
```

02. Упрощение конструкций с булевскими функциями

Не правильно:

``` 
if (isEven(number) == true) {
	// ...
}
```

Правильно:

```
if (isEven(number)) {
	// ...
}
```

Не правильно:

```
if (isEven(number) == false) {
	// ...
}
```

Правильно:

```
if (!isEven(number)) {
	// ...
}
```

03. Использование фигурных скобов:

Не правильно:

```
if (isEven(number)) sum += number;
```

Правильно:

```
if (isEven(number)) {
	sum += number;
}
```

04. Скобки

```
class Program {
	public static void main(String args[]) {
		// ...
		if (isEven(number)) {
			int x = 5;

			while (true) {
				//..
			}
		}
	}
}
```