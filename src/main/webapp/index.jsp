<%--
  Created by IntelliJ IDEA.
  User: vlado
  Date: 17.12.2018
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Studium</title>
        <!-- Meta -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="shortcut icon" href="favicon.ico">
        <link href='http://fonts.googleapis.com/css?family=Lato:300,400,300italic,400italic' rel='stylesheet'
              type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
        <!-- Global CSS -->
        <link rel="stylesheet" href="assets/plugins/bootstrap/css/bootstrap.min.css">
        <!-- Plugins CSS -->
        <link rel="stylesheet" href="assets/plugins/font-awesome/css/font-awesome.css">
        <link rel="stylesheet" href="assets/plugins/prism/prism.css">
        <!-- Theme CSS -->
        <link id="theme-style" rel="stylesheet" href="assets/css/styles.css">
        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>

    <body data-spy="scroll">

    <!---//Facebook button code-->
    <div id="fb-root"></div>

    <!-- ******HEADER****** -->
    <header id="header" class="header">
        <div class="container">
            <h1 class="logo pull-left">
                <a class="scrollto" href="#promo">
                    <span class="logo-title">Studium</span>
                </a>
            </h1><!--//logo-->
            <nav id="main-nav" class="main-nav navbar-right" role="navigation">
                <div class="navbar-header">
                    <button class="navbar-toggle" type="button" data-toggle="collapse" data-target="#navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button><!--//nav-toggle-->
                </div><!--//navbar-header-->
                <div class="navbar-collapse collapse" id="navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li class="nav-item"><a class="scrollto" href="#promo">Начать</a></li>
                        <li class="nav-item"><a class="scrollto" href="#about">Что такое Studium?</a></li>
                        <li class="nav-item"><a class="scrollto" href="#docs">Инструкция</a></li>
                        <li class="nav-item"><a class="scrollto" href="#contact">Контакты</a></li>
                    </ul><!--//nav-->
                </div><!--//navabr-collapse-->
            </nav><!--//main-nav-->
        </div>
    </header><!--//header-->

    <!-- ******PROMO****** -->
    <section id="promo" class="promo section offset-header">
        <div class="container text-center">
            <h2 class="title">Studi<span class="highlight">um</span></h2>
            <p class="intro">Studium - система тестирования</p>
            <div class="btns">
                <a class="btn btn-cta-secondary" href="" target="_blank">Зарегистрироваться</a>
                <a class="btn btn-cta-primary"
                   href="" target="_blank">Войти</a>
            </div>
            <p class="intro">

            </p>
        </div><!--//container-->
        <div class="social-media">
            <div class="social-media-inner container text-center">
            </div>
        </div>
    </section><!--//promo-->

    <!-- ******ABOUT****** -->
    <section id="about" class="about section">
        <div class="container">
            <h2 class="title text-center">Что такое Studium?</h2>
            <p class="intro text-center">Данные проект представляет собой систему тестирования, которая позволяет создавать тесты,
                используя множество уже зарегистрированных в системе вопросов и ответсв. Алгоритм тестирования заключается в том,
                что тест ограничивается набором n-вопросов из множества вопросов {n}, поэтому студент должен показать знания правильных
                ответов не на все вопросы по теме, а на n-вопросов, случайно отобранных из этого множества. Это затрудняет механическую
                подготовку ответов. Ответы также перемешиваются (меняется порядок), что в свою очередь также затрудняет механическое
                запоминание ответов.</p>
        </div><!--//container-->
    </section><!--//about-->

    <!-- ******DOCS****** -->
    <section id="docs" class="docs section">
        <div class="container">
            <div class="docs-inner">
                <h2 class="title text-center">Инструкция</h2>
                <p class="intro text-center">
                    Инструкция по пользованию системой тестирования для преподавателей и студентов.
                </p>
                <div class="block">
                    <h3 class="sub-title text-center">Для преподавателей</h3>
                    <p>

                    </p>
                </div><!--//block-->
                <div class="block">
                    <h3 class="sub-title text-center">Для студентов</h3>
                    <p>

                    </p>
                </div><!--//block-->

            </div><!--//docs-inner-->
        </div><!--//container-->
    </section><!--//features-->

    <!-- ******CONTACT****** -->
    <section id="contact" class="contact section has-pattern">
        <div class="container">
            <div class="contact-inner">
                <h2 class="title  text-center">Контакты</h2>
                <p class="intro  text-center">Данные проект был разработан с целью улучшения качества обучения.
                    <br/>При возникновении конкретных вопросов можете обратиться к разработчикам или администратору системы.</p>
                <div class="author-message">
                    <p>Владислав Овчинников: vladovchinnikov950@gmail.com</p>
                </div><!--//info-->
            </div><!--//contact-inner-->
        </div><!--//container-->
    </section><!--//contact-->

    <!-- ******FOOTER****** -->
    <footer class="footer">
        <div class="container text-center">
            <!--/* This template is released under the Creative Commons Attribution 3.0 License. Please keep the attribution link below when using for your own project. Thank you for your support. :) If you'd like to use the template without the attribution, you can check out other license options via our website: themes.3rdwavemedia.com */-->
            <small class="copyright">Designed with by Ovchinnikov Vladislav for developers
            </small>
        </div><!--//container-->
    </footer><!--//footer-->

    <!-- Javascript -->
    <script type="text/javascript" src="assets/plugins/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="assets/plugins/jquery.easing.1.3.js"></script>
    <script type="text/javascript" src="assets/plugins/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="assets/plugins/jquery-scrollTo/jquery.scrollTo.min.js"></script>
    <script type="text/javascript" src="assets/plugins/prism/prism.js"></script>
    <script type="text/javascript" src="assets/js/main.js"></script>
    </body>
</html>
