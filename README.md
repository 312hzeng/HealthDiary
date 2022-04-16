HealthData Project 
===

# HealthDiary

## Table of Contents
1. [Overview](#Overview)
1. [Product Spec](#Product-Spec)
1. [Wireframes](#Wireframes)
2. [Schema](#Schema)

## Overview
HealthDiary let the users record their health data(wake up time, bedtime, exercise time, etc) in the main page, after the user submit the data, the data will be stored in a database system.

### Description
This app records the health data about the users and have warnings when users have some unhealthy behaviors such as sleeping for less than 5 hours.

### App Evaluation
[Evaluation of your app across the following attributes]
- **Category:** Health
- **Mobile:** Android
- **Story:** 
- **Market:** All ages
- **Habit:** 
- **Scope:** 

## Product Spec

### 1. User Stories (Required and Optional)

**Required Must-have Stories**

* users are able to log in and sign up
* users are able to view their own health data
* users are able to view others' health data
* the app will warn the user when the user sleep for less than 5 hours for a day
* the app will store the user info in a database system

**Optional Nice-to-have Stories**

* simple and neat UI design
* the app allows user to submit post with images
* the app allows user to comment on other people's post

### 2. Screen Archetypes

* Sign in Screen
   * user sign in and sign up
   * go to main page when sign in successfully
* Main
   * user are able to post their health data
* Feed
   * user are able to view a list of health data

### 3. Navigation

**Tab Navigation** (Tab to Screen)

* submit
* sign in
* sign up

**Flow Navigation** (Screen to Screen)

* Sign in Page
   * after the sign in button is pressed, the page automatically nevigates to Main, where users can submit their own health data
* Main
   * after the submit button is pressed, the page automatically nevigates to Feed, where users can view a list of health data

## Wireframes
[Add picture of your hand sketched wireframes in this section]
<img src="https://github.com/312hzeng/HealthDiary/blob/master/walkthrough.gif" width=600>

## Schema 
[This section will be completed in Unit 9]

