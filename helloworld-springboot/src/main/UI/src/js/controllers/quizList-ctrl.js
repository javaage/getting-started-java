/**
 * Alerts Controller
 */

angular
    .module('RDash')
    .controller('QuizListCtrl', ['$rootScope', '$scope','$log', '$state', '$uibModal','app.services','NgTableParams', QuizListCtrl]);
function QuizListCtrl($rootScope, $scope, $log,$state,$uibModal, services,NgTableParams) {
    $scope.quizs = [];

    $scope.getQuizList = function(){
        services.getQuizList().then(function(result) {
            if (result.code == 1) {
                $scope.quizs = result.data;

                angular.forEach($scope.quizs, function (item, index) {
                    if(item.audienceType == 'R'){
                        item.audienceTypeValue = 'By Role';
                    }else if(item.audienceType == 'U'){
                        item.audienceTypeValue = 'By User';
                    }
                });

                $scope.tableParams = new NgTableParams(
                {
                    page: 1,            // show first page
                    count: 10,           // count per page
                    sorting: { active:'desc', quizName: 'asc'}
                },
                {
                    total: 0, // length of data
                    dataset: result.data
                });
            }
        }, function (error) {
            console.log(error);    
        });       
    }

    $scope.addQuizModal = function(){
        //var scope = $rootScope.$new();
        $scope.quiz = {};
        $scope.isModify = false;
        var params = {'quiz':null};
        $state.go('quiz', params);
    };

    $scope.inactiveQuiz = function(quiz){
        quiz.active = false;
        services.updateQuizOnly(quiz).then(function(result) {
            if (result.code == 1) {
                //alert("success");
            }
        }, function (error) {
            console.log(error);    
        });
    };

    $scope.activeQuiz = function(quiz){
        quiz.active = true;
        services.updateQuizOnly(quiz).then(function(result) {
            if (result.code == 1) {
                //alert("success");
            }
        }, function (error) {
            console.log(error);    
        });
    };

    $scope.updateQuizModal = function(quiz){
        $scope.quiz = quiz;
        $scope.isModify = true;
        var params = {'quiz':quiz};
        $state.go('quiz', params);
    };

    $scope.getQuizList();
}