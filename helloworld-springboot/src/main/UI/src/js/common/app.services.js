angular
    .module('RDash')
        .service('app.services', ['$http','$q','app.environments',function ($http,$q,environments) {
        	var url = environments.services.customService.url;
            var deferred = $q.defer();
            this.getUserList = function(){
            	$http.get(url.getUserList,{})
            	.success(function(data){
            		console.log(data);
                    if (data.code == 1) {
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
        }]);