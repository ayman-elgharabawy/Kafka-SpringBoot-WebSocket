// app.js
 angular.module('routerApp', ['ui.router','app.login','app.mi'])

.config(function($stateProvider, $urlRouterProvider) {

    $stateProvider
        .state('home', {
            url: '/home',
            templateUrl: 'app/login/login.view.html',
            controller: 'loginController'
        })

        .state('profile', {
            url: '/profile',
            templateUrl: 'app/mi/mi.view.html',
            controller: 'miController'
        });
    $urlRouterProvider.otherwise('/home');

});
