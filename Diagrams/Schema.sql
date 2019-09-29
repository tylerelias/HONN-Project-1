Table Person as Per {
  id int
  user_group int
  first_name varchar
  last_name varchar
  email varchar
  phone_number varchar
  address varchar
}

Table Publication as Pub {
  id int
  first_name varchar
  last_name varchar
  title varchar
  isbn varchar
  journal varchar
  year int
  type string
}

Table Borrow as Bor {
  id int
  person_id int [ref: > Per.id]
  borrow_date datetime
  return_date datetime
  publication_id int [ref: > Pub.id]
}
