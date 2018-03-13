/**
 * Alerts Controller
 */

angular
    .module('RDash')
    .controller('QuizCtrl', ['$rootScope', '$scope', '$filter', '$state', '$stateParams', '$log','$uibModal','app.services','NgTableParams', QuizCtrl]);
function QuizCtrl($rootScope, $scope, $filter, $state, $stateParams, $log, $uibModal, services,NgTableParams) {
    $scope.courses = [];
    
    $scope.roles = [];
    $scope.users = [];

    if($stateParams.quiz){
        $scope.quiz = $stateParams.quiz;
        $scope.quiz.questions = [];
        $scope.isModify = true;
    }else{
        $scope.quiz = {};
        $scope.quiz.questions = [];
        $scope.isModify = false;
    }

    var questionEmpty = {
            number: $scope.quiz.questions.length+1,
            subject: '',
            cs: ['','','',''],
            answer: ''
    };

    $scope.getRoleList = function(){
        services.getRoleList().then(function(result) {
            if (result.code == 1) {
                $scope.roles = result.data;
            }
        }, function (error) {
            console.log(error);    
        });       
    };

    $scope.getUserList = function(){
        services.getUserList().then(function(result) {
            if (result.code == 1) {
                $scope.users = result.data;
            }
        }, function (error) {
            console.log(error);    
        });       
    };

    $scope.addQuestion = function(){
        $('.collapse').collapse('hide');
        var questionEmpty = {
            number: $scope.quiz.questions.length+1,
            subject: '',
            cs: ['','','',''],
            answer: ''
        }
        $scope.quiz.questions.push(questionEmpty);
    };

    $scope.deleteQuestion = function(question){
        for(var i=0; i<$scope.quiz.questions.length;i++){
            if($scope.quiz.questions[i]==question){
                $scope.quiz.questions.splice(i,1);
                break;
            }
        }
        
        if($scope.quiz.questions.length==0){
            $scope.quiz.questions.push(questionEmpty);
        }
    };

    $scope.openDatePicker = function(){
        $('#datetimepicker').datetimepicker({
            autoclose: true,
            format: 'yyyy-mm-dd hh:ii'
        });

        $('#datetimepicker').datetimepicker('show');
    };

    $scope.getCourseList = function(){
        services.getCourseList().then(function(result) {
            if (result.code == 1) {

                angular.forEach(result.data,function(value,key){
                    if(value.startDate>0)
                        value.startDate = new Date(value.startDate);
                    if(value.endDate>0)
                        value.endDate = new Date(value.endDate);
                });

                $scope.courses = result.data;

                if($scope.isModify){
                    for(var index = 0; index < $scope.courses.length; index++){
                        var course = $scope.courses[index];
                        if(course.id == $scope.quiz.courseID){
                            $scope.quiz.course = $scope.courses[index];
                            $scope.quiz.activeTime = $filter('date')( $scope.quiz.course.startDate ,'yyyy-MM-dd') + ' 09:00';
                            break;
                        }
                    }

                }else{
                    $scope.quiz.course = $scope.courses[0];
                    $scope.quiz.activeTime = $filter('date')( $scope.quiz.course.startDate ,'yyyy-MM-dd') + ' 09:00';
                }
                
            }
        }, function (error) {
            console.log(error);    
        });       
    };

    $scope.updateQuiz = function(quiz){
        services.updateQuiz(quiz).then(function(result) {
            if (result.code == 1) {
                alert("success");
            }
        }, function (error) {
            console.log(error);    
        });
    };

    $scope.changeCourse = function(){
        $scope.quiz.activeTime = $filter('date')( $scope.quiz.course.startDate ,'yyyy-MM-dd') + ' 09:00';
    };

    $scope.submitQuizData = function(){
        $scope.quiz.courseID = $scope.quiz.course.id;

        var list = [];

        if($scope.quiz.audienceType=='R'){
            for(var i = 0; i < $scope.quiz.roleList.length; i++){
                list.push($scope.quiz.roleList[i].id);
            }
        }else{
            for(var i = 0; i < $scope.quiz.userList.length; i++){
                list.push($scope.quiz.userList[i].id);
            }
        }

        $scope.quiz.audienceList = list.join(',');
        
        for(var i = 0; i < $scope.quiz.questions.length; i++){
            var question = $scope.quiz.questions[i];
            question.choices = question.cs.join('|||');
        }


        if($scope.isModify){
                services.updateQuiz($scope.quiz).then(function(result) {
                    if (result.code == 1) {
                        $state.go('quizList');
                    }
                }, function (error) {
                    console.log(error);    
                });
        }else{
                services.addQuiz($scope.quiz).then(function(result) {
                    if (result.code == 1) {
                        $state.go('quizList');
                    }
                }, function (error) {
                    console.log(error);    
                });
        }
    };

    $scope.closeQuizModal = function(){
        $state.go('quizList');
    };

    $scope.init = function(){
        $scope.getCourseList();
        $scope.getRoleList();
        $scope.getUserList();

        $scope.quiz.activeTime = $filter('date')(new Date(),'yyyy-MM-dd hh:mm');

        if($scope.isModify){

            services.getQuiz($scope.quiz.id).then(function(result) {
                    if (result.code == 1) {
                        $scope.quiz.questions = result.data.listQuestionModel;

                        angular.forEach($scope.quiz.questions,function(item,key){
                            item.cs = item.choices.split('|||');
                        });

                        if($scope.quiz.audienceType == 'R'){
                            $scope.quiz.roleList=result.data.listRoleModel;
                        }else{
                            $scope.quiz.userList=result.data.listUserModel;
                        }
                        
                    }
                }, function (error) {
                    console.log(error);    
                });    

        }else{
            
            $scope.quiz.audienceType = 'R';
            $scope.quiz.questions.push(questionEmpty);
        }
        
    };

    $scope.init();
}