'use strict';

/**
 * Route configuration for the RDash module.
 */
angular.module('RDash').config(['$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider) {

        // For unmatched routes
        $urlRouterProvider.otherwise('/employee');

        // Application routes
        $stateProvider
            .state('employee', {
                url: '/employee',
                templateUrl: 'templates/employee.html'
            }) 
            .state('role', {
                url: '/role',
                templateUrl: 'templates/role.html'
            }) 
            .state('course', {
                url: '/course',
                templateUrl: 'templates/course.html'
            }) 
            .state('sample', {
                url: '/sample',
                templateUrl: 'templates/sample.html'
            })        
            // .state('index', {
            //     url: '/',
            //     templateUrl: 'templates/dashboard.html'
            // })
            // .state('tables', {
            //     url: '/tables',
            //     templateUrl: 'templates/tables.html'
            // })
            ;
    }
]);