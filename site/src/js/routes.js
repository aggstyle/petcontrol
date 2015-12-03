'use strict';

/**
 * Route configuration for the RDash module.
 */
angular.module('petcontrol').config(['$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider) {

        // For unmatched routes
        $urlRouterProvider.otherwise('/');

        // Application routes
        $stateProvider
            .state('index', {
                url: '/',
                templateUrl: 'templates/dashboard.html'
            })
            .state('animais', {
                url: '/animais',
                templateUrl: 'templates/animais.html'
            })
            .state('pessoas', {
                url: '/pessoas',
                templateUrl: 'templates/pessoas.html'
            })
            .state('usuario', {
                url: '/usuario',
                templateUrl: 'templates/usuario.html'
            })
            .state('ongs', {
                url: '/ongs',
                templateUrl: 'templates/ongs.html'
            })
            .state('adocoes', {
                url: '/adocoes',
                templateUrl: 'templates/adocoes.html'
            })
            .state('atendveterinario', {
                url: '/atendveterinario',
                templateUrl: 'templates/atendveterinario.html'
            });
    }
]);
