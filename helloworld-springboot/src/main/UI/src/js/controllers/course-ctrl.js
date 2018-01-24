/**
 * Alerts Controller
 */

angular
    .module('RDash')
    .controller('CourseCtrl', ['$rootScope', '$scope','$log','$uibModal','app.services','NgTableParams', CourseCtrl])
    .controller('OperateCourseCtrl', ['$scope','$log','$uibModalInstance','app.services', OperateCourseCtrl]);
function CourseCtrl($rootScope, $scope, $log,$uibModal, services,NgTableParams) {
    $scope.courses = [];
    
    $scope.cancel = function() {
      $uibModalInstance.dismiss('cancel');
    };

    $scope.getCourseList = function(){
        services.getCourseList().then(function(result) {
            if (result.code == 1) {
                $scope.courses = result.data;
                $scope.tableParams = new NgTableParams(
                {
                    page: 1,            // show first page
                    count: 10,           // count per page
                    sorting: { active:'desc', courseName: 'asc'}
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

    $scope.addCourseModal = function(){
        //var scope = $rootScope.$new();
        $scope.course = {};
        $scope.isModify = false;
        var modalInstance = $uibModal.open({
            scope: $scope,
            animation: true,
            templateUrl: 'courseModal.html',
            controller: 'OperateCourseCtrl'
        });
        modalInstance.opened.then(function(){
            $('.datepicker').datepicker({
            });
        });
    };

    $scope.inactiveCourse = function(course){
        course.active = false;
        services.updateCourse(course).then(function(result) {
            if (result.code == 1) {
                //alert("success");
            }
        }, function (error) {
            console.log(error);    
        });
    };

    $scope.activeCourse = function(course){
        course.active = true;
        services.updateCourse(course).then(function(result) {
            if (result.code == 1) {
                //alert("success");
            }
        }, function (error) {
            console.log(error);    
        });
    };

    $scope.updateCourseModal = function(course){
        //var scope = $rootScope.$new();
        $scope.course =course;
        $scope.isModify = true;
        var modalInstance = $uibModal.open({
            scope: $scope,
            animation: true,
            templateUrl: 'courseModal.html',
            controller: 'OperateCourseCtrl',
        });
    };

    $scope.updateCourse = function(course){
        services.updateCourse(course).then(function(result) {
            if (result.code == 1) {
                alert("success");
            }
        }, function (error) {
            console.log(error);    
        });
    };

    $scope.getCourseList();
}

function OperateCourseCtrl($scope, $log,$uibModalInstance, services) { 


    $scope.closeCourseModal = function(){
        $uibModalInstance.dismiss();
    };

    $scope.openStartDate = function($event) {
      $event.preventDefault();
      $event.stopPropagation();

      $scope.openedStartDate = true;
    };

    $scope.openEndDate = function($event) {
      $event.preventDefault();
      $event.stopPropagation();

      $scope.openedEndDate = true;
    };

    $scope.submitCourseData = function(){
        	if($scope.isModify){
                services.updateCourse($scope.course).then(function(result) {
                    if (result.code == 1) {
                        $scope.getCourseList();
                        $scope.closeCourseModal();
                    }
                }, function (error) {
                    console.log(error);    
                });
            }else{
                services.addCourse($scope.course).then(function(result) {
                    if (result.code == 1) {
                        $scope.getCourseList();
                        $scope.closeCourseModal();
                    }
                }, function (error) {
                    console.log(error);    
                });
            }
    };
    


}