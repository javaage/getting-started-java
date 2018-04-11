/**
 * Alerts Controller
 */

angular
    .module('RDash')
    .controller('CourseCtrl', ['$rootScope', '$scope','$log','$uibModal','app.services','NgTableParams', CourseCtrl])
    .controller('OperateCourseCtrl', ['$scope','$filter','$log','$uibModalInstance','app.services', OperateCourseCtrl]);
function CourseCtrl($rootScope, $scope, $log,$uibModal, services,NgTableParams) {
    $scope.courses = [];
    
    $scope.cancel = function() {
      $uibModalInstance.dismiss('cancel');
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
                //alert("success");
            }
        }, function (error) {
            console.log(error);    
        });
    };

    $scope.getCourseList();
}

function OperateCourseCtrl($scope,$filter,$log,$uibModalInstance,services) { 


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
        $scope.dataLoading = true;

        $scope.course.startDate = $filter('date')($scope.course.startDate,'yyyy-MM-dd');
        $scope.course.endDate = $filter('date')($scope.course.endDate,'yyyy-MM-dd');

        	if($scope.isModify){
                services.updateCourse($scope.course).then(function(result) {
                    $scope.dataLoading = false;
                    if (result.code == 1) {
                        $scope.getCourseList();
                        $scope.closeCourseModal();
                    }
                }, function (error) {
                    console.log(error); 
                    $scope.dataLoading = false;   
                });
            }else{
                services.addCourse($scope.course).then(function(result) {
                    $scope.dataLoading = false;
                    if (result.code == 1) {
                        $scope.getCourseList();
                        $scope.closeCourseModal();
                    }
                }, function (error) {
                    console.log(error); 
                    $scope.dataLoading = false;   
                });
            }
    };
    


}