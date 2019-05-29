# commodity-classifier
Описание классификатора дерева товаров интернет-магазина obi.ru 

В данном проекте была использована ORM Apache Cayenne, в комплекте с которой идет Cayenne Modeler, в котором были спроектированы и описаны объекты системы.
Файлы, которые находятся в папке resources отвечают за проект в Modeler. От их содержимого зависит генерация Java классов таблиц СУБД PostgreSQL 

Классификатор позволяет задавать ограничения по возможным значениям, создавать группы свойств, описывать эти свойства.

<br>
Пример:<br>
<ol>
 <h3>Электроника:</h3>
  <li>
    <ul><h2>Дрели:</h2>
       <li>Дрель %Имя_дрели%, Технический параметр: вес 50 КГ</li>
    </ul>
  </li>
</ol>

