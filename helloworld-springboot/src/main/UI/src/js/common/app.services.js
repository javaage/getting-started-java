angular
    .module('RDash')
        .service('app.services', ['$http','$q','app.environments',function ($http,$q,environments) {
        	var url = environments.services.customService.url;

            this.isEmptyOrNull = function (obj) {
                /// <summary>
                /// Retrieve true when object is empty, undefined or null.
                /// </summary>
                /// <param name='obj'>Object to be checked</param>
                /// <returns type='boolean'>True when object is empty, undefined or null.</returns>
                /// <doc>myPerformance.factory:methods#isEmptyOrNull</doc>
                return ((obj === undefined) ||
                    (obj === null) ||
                    (angular.isString(obj) && (obj === '')) ||
                    (angular.isArray(obj) && (obj.length === 0)) // Arrays
                );
            };

            this.urlFormat = function () {
                /// <summary>
                /// Format url using string.format way to match parameters.
                /// </summary>
                /// <returns type='string'>String parsed.</returns>
                /// <doc>myPerformance.factory:methods#urlFormat</doc>
                var args = arguments, url = '', baseUrl = '', qs = '', qsFormatted = '', splitted, vars = [], hash, i;
                if (this.isEmptyOrNull(args)) {
                    return '';
                }
                if (args.length === 1) {
                    url = args[0];
                }
                else {
                    url = args[0].replace(/\{(\d+)\}/g, function (match, number) {
                        return args[parseInt(number, 10) + 1] !== undefined ? encodeURIComponent(args[parseInt(number, 10) + 1]) : '';
                    });
                }
                // Remove empty qs parameters
                if (url.indexOf('?') >= 0) {
                    splitted = url.split('?');
                    baseUrl = splitted[0];
                    if (splitted.length > 1) {
                        qs = splitted[1].split('&');
                        for (i = 0; i < qs.length; i++) {
                            if (qs[i].indexOf('=') >= 0) {
                                hash = qs[i].split('=');
                                vars.push({ code: hash[0], value: hash[1] });
                            }
                            else {
                                vars.push({ code: qs[i], value: '' });
                            }
                        }
                        // Fill qsFormatted using vars and removing empty values
                        for (i = 0; i < vars.length; i++) {
                            if (vars[i].value && vars[i].value !== '') {
                                qsFormatted = qsFormatted + ((qsFormatted === '') ? '?' : '&') + vars[i].code + '=' + vars[i].value;
                            }
                        }
                    }
                }
                else {
                    baseUrl = url;
                }
                return baseUrl + qsFormatted;
            };

            this.getUserList = function(){
                var deferred = $q.defer();
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

            this.addUser = function(user){
                var deferred = $q.defer();
                $http.post(url.addUser,user)
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

            this.updateUser = function(user){
                var deferred = $q.defer();
                var urlQuery = this.urlFormat(url.updateUser,user.id);
                $http.put(urlQuery,user)
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

            this.checkUser = function(id){
                var deferred = $q.defer();
                var urlCheck = this.urlFormat(url.checkUser,id);
                $http.get(urlCheck,{})
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
            }

            this.getRoleList = function(){
                var deferred = $q.defer();
                $http.get(url.getRoleList,{})
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

            this.addRole = function(role){
                var deferred = $q.defer();
                $http.post(url.addRole,role)
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

            this.updateRole = function(role){
                var deferred = $q.defer();
                var urlQuery = this.urlFormat(url.updateRole,role.name);
                $http.put(urlQuery,role)
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

            this.getRecordList = function(){
                var deferred = $q.defer();
                $http.get(url.getRecordList,{})
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

            this.addRecord = function(record){
                var deferred = $q.defer();
                $http.post(url.addRecord,record)
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

            this.updateRecord = function(record){
                var deferred = $q.defer();
                var urlQuery = this.urlFormat(url.updateRecord,record.name);
                $http.put(urlQuery,record)
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

            this.getCourseList = function(){
                var deferred = $q.defer();
                $http.get(url.getCourseList,{})
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

            this.addCourse = function(course){
                var deferred = $q.defer();
                $http.post(url.addCourse,course)
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

            this.updateCourse = function(course){
                var deferred = $q.defer();
                var urlQuery = this.urlFormat(url.updateCourse,course.name);
                $http.put(urlQuery,course)
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
            this.getGoldenSampleList = function(){
                var deferred = $q.defer();
                $http.get(url.getGoldenSampleList,{})
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

            this.addGoldenSample = function(course){
                var deferred = $q.defer();
                $http.post(url.addGoldenSample,course)
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

            this.updateGoldenSample = function(course){
                var deferred = $q.defer();
                var urlQuery = this.urlFormat(url.updateGoldenSample,course.name);
                $http.put(urlQuery,course)
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

            this.getRoleHistoryListByUserID = function(userID){
                var deferred = $q.defer();
                var urlQuery = this.urlFormat(url.getRoleHistoryListByUserID,userID);
                $http.get(urlQuery,{})
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

            this.getCourseHistoryListByUserID = function(userID){
                var deferred = $q.defer();
                var urlQuery = this.urlFormat(url.getCourseHistoryListByUserID,userID);
                $http.get(urlQuery,{})
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

            this.importUsers = function(file){
                var deferred = $q.defer();

                $http({
                    url: url.importUsers,
                    method: "POST",
                    transformRequest: function(){
                        var formData = new FormData();
                        formData.append('file', file);
                        return formData;
                    },
                    headers: {'Content-Type': undefined}
                })
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