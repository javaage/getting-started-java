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
            .state('quiz', {
                url: '/quiz',
                params: {'quiz': null},
                templateUrl: 'templates/quiz.html',
                controller: 'QuizCtrl'
            }) 
            .state('quizList', {
                url: '/quizList',
                templateUrl: 'templates/quizList.html',
                controller: 'QuizListCtrl'
            }) 
            .state('course', {
                url: '/course',
                templateUrl: 'templates/course.html',
                controller: 'CourseCtrl'
            }) 
            .state('sample', {
                url: '/sample',
                templateUrl: 'templates/sample.html',
                controller: 'GoldenSampleCtrl'
            })  
            .state('record', {
                url: '/record',
                templateUrl: 'templates/record.html',
                controller: 'RecordCtrl'
            })  
            .state('setting', {
                url: '/setting',
                templateUrl: 'templates/setting.html',
                controller: 'SettingCtrl'
            });
    }
]);