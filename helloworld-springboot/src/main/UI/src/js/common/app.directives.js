angular
.module('RDash')
.directive('account',  ['$http','$q', '$timeout', 'app.environments','app.services',function($http, $q, $timeout,environments,services) {
  return {
    scope: true,
    require: 'ngModel',
    link: function(scope, elm, attrs, ctrl) {
      var url = environments.services.customService.url;

      ctrl.$asyncValidators.account = function(modelValue, viewValue) {

        if (ctrl.$isEmpty(modelValue) || scope.isModify) {
          return $q.resolve();
        }

        var deferred = $q.defer();
        var urlCheck = services.urlFormat(url.checkUser,modelValue);
        $http.get(urlCheck,{})
            .success(function(data){
                console.log(data);
                if (data.code == 1 && data.data) {
                    deferred.resolve(data);
                } else {
                    deferred.reject(data);
                }
            })
            .error(function(error){
                deferred.reject(error);
            });

        return deferred.promise;
      };
    }
  };
}])
.directive('budgetvalid',  ['$http','$q', '$timeout', 'app.environments','app.services',function($http, $q, $timeout,environments,services) {
  return {
    scope: true,
    require: 'ngModel',
    link: function(scope, elm, attrs, ctrl) {
        scope.$watch(attrs.ngModel,function(value,oldValue){

            if(attrs.ngModel == 'user.budget')
                scope.user.budget = value;
            else if(attrs.ngModel == 'user.balance')
                scope.user.balance = value;

            if(scope.user.budget != null && scope.user.balance != null){
                if(scope.user.balance > scope.user.budget){
                    scope.userForm.budget.$setValidity('budgetvalid', false);
                    scope.userForm.balance.$setValidity('budgetvalid', false);
                }else{
                    scope.userForm.budget.$setValidity('budgetvalid', true);
                    scope.userForm.balance.$setValidity('budgetvalid', true);
                }
            }else{
                scope.userForm.budget.$setValidity('budgetvalid', true);
                scope.userForm.balance.$setValidity('budgetvalid', true);
            }
        });      
    }
  };
}])
;