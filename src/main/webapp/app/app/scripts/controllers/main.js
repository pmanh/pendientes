( function () {
	'use strict';

	/**
	 * @ngdoc function
	 * @name pendietesApp.controller:MainCtrl
	 * @description
	 * # MainCtrl
	 * Controller of the pendietesApp
	 */
	angular.module('FamsaPendings')
	  .controller('MainCtrl', ['$scope','Pending','Type', MainCtrl]);
	
	/**
	 * 
	 * @param $scope
	 * @param Pending
	 * @param Type
	 * @returns
	 */
	function MainCtrl($scope, Pending, Type) {
		  var vm = this;
		$scope.pendings =[];
	    $scope.yeomanImg = ctxPath+"images/famsa.png";
	    $scope.config = {
	    	    itemsPerPage: 5,
	    	    fillLastPage: true
	    	  }
	    
	    $scope.loadTypes = loadTypes;
	    $scope.loadPendings = loadPendings;

	    $scope.addType = function(){
	    	bootbox.prompt("Escriba el nuevo tipo de pendientes", function(result){    		
	    		if(result && result.trim().length > 0){
	    			Type.save({type:result}, function(resp){
	    		    	$scope.loadTypes();
	    		    });
	    		}
	    	});
	    }
	    
	    
	    $scope.savePending = function(){
	    	if($scope.pending.title && $scope.pending.title.trim().length >0){
		    	if($scope.pending.id){
		    		Pending.update($scope.pending).$promise.then(function(resp) {
		    			$scope.pending = {};
		    	    	$scope.loadPendings()
		    		});
		    	}else{
		    		Pending.save($scope.pending).$promise.then(function(resp) {
		    			$scope.pending = {};
		    	    	$scope.loadPendings()
		    		});    		
		    	}
	    	}
	    }
	    
	    $scope.deletePending = function(item){
	    	bootbox.confirm({
	    	    message: "\u00bfEsta seguro que desea eliminar el registro?",
	    	    buttons: {
	    	        confirm: {
	    	            label: 'Continuar',
	    	            className: 'btn-success'
	    	        },
	    	        cancel: {
	    	            label: 'Cancelar',
	    	            className: 'btn-danger'
	    	        }
	    	    },
	    	    callback: function (result) {
	    	       if(result){
		    	       	Pending.drop(item).$promise.then(function(resp) {
		    	        	$scope.loadPendings()
		    	    	});
	    	       }
	    	    }
	    	});

	    }
	    
	    $scope.editPending = function(item){
	    	if(item.idType && item.idType.id)
	    		item.idType.id +='';
	    	$scope.pending = item;
	    }
	    
	    $scope.submitfile =  function submitfile(){
	    	console.log('do')
	    	console.log($("#upload_form"))
		    var formdata = new FormData($("#upload_form"));
		    $.ajax({
		        type: "POST",
		        url: "http://localhost:8080/alfresco/service/api/upload?alf_ticket=TICKET_58f816fc90d18ed0aea284cbfed16ba8bbb087a2",
		        data: formdata,
		        processData: false,
		        contentType: false,
		        dataType: "json",
		        success: function(data, textStatus, jqXHR) {
		        	console.log(data)
		           //process data
		        },
		        error: function(data, textStatus, jqXHR) {
		        	console.log(data)
		           //process error msg
		        },
		    });
	    }
	    
	    /**
	     * 
	     */
	    function loadTypes(){
	    	console.debug('loadTypes -->')
	    	Type.get({}).$promise.then(function(types) {
	    		$scope.types = types.data;
	    		console.debug('loadTypes ==>')
	    	});
	    	console.debug('loadTypes //>')
	    }
	   
	   /**
	    * 
	    */
	   function loadPendings(idType){
	    	$scope.filter = {};
	    	if(idType)
	    		$scope.filter = {'idType.id':idType};
	    	Pending.get($scope.filter).$promise.then(function(resp) {
	    		$scope.pendings = resp.data;
	    	});
	    }	    
	  }
})();
