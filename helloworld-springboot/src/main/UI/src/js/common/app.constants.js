/**
 * Loading Directive
 * @see http://tobiasahlin.com/spinkit/
 */

angular
    .module('RDash')
    .constant('app.constants',{
    	environments: {
	        PRO: 'PRO',
	        UAT: 'UAT',
	        SIT: 'SIT',
	        MOCK: 'MOCK'
    	}
    });