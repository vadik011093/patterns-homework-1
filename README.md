# patterns-homework-1

1. Поля класса Tractor не скрыты. Инкапсулируем логику.
2. Поля:
  int[] position = new int[] { 0, 0 };
	int[] field = new int[] { 5, 5 };
	приведем к объектному стилю, создав класс Position, Field. Классу Tractor нет необходимости знать на каком поле он находится - уберем поле field.
3. В классе Tractor много if констуркций - необходимо перейти к полиморфизму, используя паттерн State
4. В Tractor зашиты команды. При добавлении новых комманд придется изменять текущий класс. Вынесем команды в абстракцию, применив паттерн Command.
