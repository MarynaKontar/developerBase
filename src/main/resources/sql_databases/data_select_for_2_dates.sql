-- Сравнение данных за две даты
-- Здесь вместо явно указанных таблиц, благодаря использованию псевдонимов, 
-- будут применяться результирующие таблицы вложенных запросов с имеющейся 
-- связью один – к – одному. Результатом каждой результирующей таблицы будут 
-- данные о количестве произведенных заказов некоего товара за определенную дату, 
-- полученные путем выполнения запроса на выборку данных из таблицы statistics 
-- по требуемым критериям. Иными словами мы свяжем таблицу statistics саму с собой.

SELECT stat1.Name, stat1.Orders, stat1.Date, stat2.Orders, stat2.Date FROM 
(SELECT statistics.ProductID, products.Name, statistics.Orders, statistics.Date 
FROM products JOIN statistics ON products.id = statistics.ProductID WHERE 
DATE(statistics.date) = '2014-09-04') AS stat1 JOIN (SELECT statistics.ProductID, 
statistics.Orders, statistics.Date FROM statistics WHERE DATE(statistics.date) = 
'2014-09-12') AS stat2 ON stat1.ProductID = stat2.ProductID;