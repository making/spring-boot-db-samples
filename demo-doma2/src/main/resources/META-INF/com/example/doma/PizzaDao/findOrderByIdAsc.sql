SELECT
  p.id AS id,
  p.name AS name,
  p.price AS price,
  b.id   AS base_id,
  b.name AS base_name,
  t.id   AS topping_id,
  t.name AS topping_name
FROM pizza p
  INNER JOIN base b ON (b.id = p.base_id)
  INNER JOIN pizza_toppings pt ON (pt.pizza_id = p.id)
  INNER JOIN topping t ON (t.id = pt.toppings_id)
ORDER BY p.id ASC