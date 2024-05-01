# RailwayReservationSystem

IDE: SpringBoot(2.5.6)
Language: Java(17)


MySQL Tables:
1.booking details
  primary key: booking_id(int)
2.TrainInfo
  primary key: train_id(int)
3.userinfo
  primary key: user_id(int)

Database : railway
comand: create database railway;

No need to add data manually or using insert cmd. Basic structure will be done by Springboot itself.


Screenshot:

First using API - "api/sign-in" add an admin
then use "api/login" api to get the token for admin related api.
use this token mainly for "api/trains"


Import the project in springboot and in mail class right click and run as springboot app and use postman to run RestAPI.
