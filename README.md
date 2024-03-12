# To run this project on your local machine follow the following steps:-

1- clone this repository

2- run this project through your prefered ide

3- open http://localhost:8765




# This cart service has several functionality:-

1) Get all carts - by going to http://localhost:8765/carts

![image](https://github.com/looper12349/CartService/blob/main/assets/1.png)


2) Get a single cart - by going to http://localhost:8765/carts/{id}

![image](https://github.com/looper12349/CartService/blob/main/assets/2.png)


3) Get carts in date range - by following the following structure:-
         http://localhost:8765/carts?startdate=2019-12-10&enddate=2020-10-10
   you can change the startDate or endDate

![image](https://github.com/looper12349/CartService/blob/main/assets/3.png)

4) Get a user's cart - by going to http://localhost:8765/carts/user/{id}

![image](https://github.com/looper12349/CartService/blob/main/assets/4.png)

5) Add a new cart - by providing a mock cart through post method by going to http://localhost:8765/carts

![image](https://github.com/looper12349/CartService/blob/main/assets/5.png)

6) Update a cart - by providing a mock cart through post method by going to http://localhost:8765/carts/{id}

![image](https://github.com/looper12349/CartService/blob/main/assets/6.png)

7) Delete a cart - by going to http://locahost:8765/carts/{id}

![image](https://github.com/looper12349/CartService/blob/main/assets/7.png)
