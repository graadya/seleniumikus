#language:ru
  Функционал: Поиск на авито

    @1
    Сценарий: Найдем самый дорогие принтеры на авито
      Пусть открыт ресурс на авито
      И в выпадающем списке категорий выбрана оргтехника
      И в поле поиска введено значение Ноутбук
      Тогда кликнуть по выпадающему списку региона
      Тогда в поле регион введено значение Владивосток
      И нажата кнопка показать объявления
      Тогда открылась страница результаты по запросу Ноутбук
      И активирован чекбокс только с фотографией
      И в выпадающем списке сортировка выбрано значение Дороже
      И в консоль выведено значение названия и цены 3 первых товаров
