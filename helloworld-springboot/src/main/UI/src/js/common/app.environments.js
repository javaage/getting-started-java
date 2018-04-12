        angular
        .module('RDash')
        .provider('app.environments', ['app.constants', function (constants) {
            function getMock() {
                return {
                    environment: 'MOCK',
                    services: {
                        customService: {
                            GMT: '+0800',
                            serviceName: 'customService',
                            identifier: '/'
                        }
                    }
                };
            }
            function getPRO() {
                return {
                    environment: 'PRO',
                    services: {
                        customService: {
                            GMT: '+0000',
                            serviceName: 'customService',
                            identifier: '/'
                        }
                    }
                };
            }
            // config object
            var config = {
                environment: '',
                services: {}
            };
            var _basicUrls = {
                getUser: '/api/user/{0}',
                getUserList: '/api/user/list',
                deleteUserByID: '/api/user/{0}',
                checkUser: '/api/user/check/{0}',
                addUser: '/api/user',
                updateUser: '/api/user',
                getRole: '/api/role/{0}',
                getRoleList: '/api/role/list',
                deleteRoleByID: '/api/role/{0}',
                addRole: '/api/role',
                getFlyer: '/api/flyer/{0}',
                getFlyerList: '/api/flyer/list',
                deleteFlyerByID: '/api/flyer/{0}',
                addFlyer: '/api/flyer',
                updateFlyer: '/api/flyer',
                updateFlyerOnly: '/api/flyer/only',
                updateRole: '/api/role',
                getQuiz: '/api/quiz/{0}',
                getQuizList: '/api/quiz/list',
                deleteQuizByID: '/api/quiz/{0}',
                addQuiz: '/api/quiz',
                updateQuiz: '/api/quiz',
                updateQuizOnly: '/api/quiz/only',
                getQuestionList: 'api/question/list/{0}',
                getRecord: '/api/record/{0}',
                getRecordList: '/api/record/list',
                deleteRecordByID: '/api/record/{0}',
                addRecord: '/api/record',
                updateRecord: '/api/record',
                getCourse: '/api/course/{0}',
                getCourseList: '/api/course/list',
                deleteCourseByID: '/api/course/{0}',
                addCourse: '/api/course',
                updateCourse: '/api/course',
                getGoldenSample: '/api/goldenSample/{0}',
                deleteGoldenSampleByID: '/api/goldenSample/{0}',
                getGoldenSampleList: '/api/goldenSample/list',
                addGoldenSample: '/api/goldenSample',
                updateGoldenSample: '/api/goldenSample',
                getCourseHistoryListByUserID: '/api/coursehistory/{0}',
                getRoleHistoryListByUserID: '/api/rolehistory/{0}',
                importUsers: '/api/import/users'
            };
            function _joinUrl(domain, path) {
                return domain.replace(/(^http.*?)\/{0,}$/, '$1/') + path.replace(/^\/{0,}(.*)/, '$1');
            }
            function _generateURLs(identifier, urls) {
                var newUrls = angular.extend({}, urls);

                angular.forEach(newUrls, function (v, k) {
                    if (typeof v == 'string') {
                        if (!(v.match(/^http/))) {
                            newUrls[k] = _joinUrl(identifier, v);
                        }
                    }
                    else {
                        newUrls[k] = _generateURLs(identifier, v);
                    }
                });
                return newUrls;
            }
            this.setEnvironment = function (environment) {
                if (environment === constants.environments.MOCK) {
                    config = getMock();
                }
                else if (environment === constants.environments.PRO) {
                    config = getPRO();
                }
                if (!config.services.customService.url) {
                    config.services.customService.url = _generateURLs(config.services.customService.identifier, _basicUrls);
                }
                if (!config.services.customService.urlParams) {
                    if (environment === constants.environments.MOCK) {
                        config.services.customService.urlParams = config.services.customService.url;
                    } else {
                        config.services.customService.urlParams = _basicUrls;
                    }
                }
                this.config = config;
            };
            this.$get = function () {
                this.setEnvironment(constants.environments.PRO);
                // this.setEnvironment(constants.environments.MOCK);
                return config;
            };

        }]);