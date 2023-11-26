import 'package:flutter/material.dart';

var theme = ThemeData(
  bottomNavigationBarTheme: BottomNavigationBarThemeData(
  backgroundColor: Colors.white,
  elevation: 2,
  selectedItemColor: Colors.black,
  ),
  appBarTheme: AppBarTheme(
    color: Colors.white,
    elevation: 1,
    titleTextStyle: TextStyle(color: Colors.black,fontSize: 25),
    actionsIconTheme: IconThemeData(color: Colors.black),
  ),
  textTheme: TextTheme(
    bodyText1: TextStyle(color: Colors.blue),
    bodyText2: TextStyle(color: Colors.red),
  ),
);