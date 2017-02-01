'use strict';

/**
 * @ngdoc overview
 * @name cotizadorApp
 * @description
 * # cotizadorApp
 *
 * Main module of the application.
 */
angular
  .module('FamsaPendings', [
    'ngAnimate',
    'ngCookies',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch',
    'angular-table'
  ])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: ctxPath + 'views/main.html',
        controller: 'MainCtrl',
        controllerAs: 'main'
      })
      .otherwise({
        redirectTo: '/'
      });
  });
