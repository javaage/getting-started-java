'use strict';

/**
 * Route configuration for the RDash module.
 */
angular.module('RDash').config(['$stateProvider', '$urlRouterProvider', '$locationProvider',
    function($stateProvider, $urlRouterProvider,$locationProvider) {

        //$locationProvider.html5Mode(true).hashPrefix('!');
        // For unmatched routes
        $urlRouterProvider.otherwise('/employee');

        // Application routes
        $stateProvider
            .state('secure', {
                template: '<div ui-view></div>',
                abstract: true,
                controller: 'AuthCtrl'
                
            })
            .state('login', {
                url: '/login',
                templateUrl: 'templates/login.view.html',
                controller: 'LoginController'
            }) 
            .state('employee', {
                parent: 'secure',
                url: '/employee',
                templateUrl: 'templates/employee.html',
                controller: 'EmployeeCtrl'
            }) 
            .state('role', {
                parent: 'secure',
                url: '/role',
                templateUrl: 'templates/role.html',
                controller: 'RoleCtrl'
            }) 
            .state('flyer', {
                parent: 'secure',
                url: '/flyer',
                templateUrl: 'templates/flyer.html',
                controller: 'FlyerCtrl'
            }) 
            .state('quiz', {
                parent: 'secure',
                url: '/quiz',
                params: {'quiz': null},
                templateUrl: 'templates/quiz.html',
                controller: 'QuizCtrl'
            }) 
            .state('quizList', {
                parent: 'secure',
                url: '/quizList',
                templateUrl: 'templates/quizList.html',
                controller: 'QuizListCtrl'
            }) 
            .state('course', {
                parent: 'secure',
                url: '/course',
                templateUrl: 'templates/course.html',
                controller: 'CourseCtrl'
            }) 
            .state('sample', {
                parent: 'secure',
                url: '/sample',
                templateUrl: 'templates/sample.html',
                controller: 'GoldenSampleCtrl'
            })  
            .state('record', {
                parent: 'secure',
                url: '/record',
                templateUrl: 'templates/record.html',
                controller: 'RecordCtrl'
            })  
            .state('setting', {
                parent: 'secure',
                url: '/setting',
                templateUrl: 'templates/setting.html',
                controller: 'SettingCtrl'
            });
    }
]);