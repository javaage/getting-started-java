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
                templateUrl: 'templates/employee.html',
                controller: 'EmployeeCtrl'
            }) 
            .state('role', {
                url: '/role',
                templateUrl: 'templates/role.html',
                controller: 'RoleCtrl'
            }) 
            .state('course', {
                url: '/course',
                templateUrl: 'templates/course.html',
                controller: 'CourseCtrl'
            }) 
            .state('sample', {
                url: '/sample',
                templateUrl: 'templates/sample.html',
                controller: 'SampleCtrl'
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