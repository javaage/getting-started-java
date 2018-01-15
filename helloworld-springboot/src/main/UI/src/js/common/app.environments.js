        angular
        .module('RDash')
        .provider('app.environments', ['app.constants', function (constants) {
            function getMock() {
                return {
                    environment: 'MOCK',
                    services: {
                        customService: {
                            serviceName: 'customService',
                            identifier: 'http://192.168.120.128:8080'
                        }
                    }
                };
            }
            function getPRO() {
                return {
                    environment: 'PRO',
                    services: {
                        customService: {
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
                deleteUser: '/api/user/{0}',
                addUser: '/api/user',
                updateUser: '/api/user/{0}'
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
                this.setEnvironment(constants.environments.MOCK);
                return config;
            };

        }]);