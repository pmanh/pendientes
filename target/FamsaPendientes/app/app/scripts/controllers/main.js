'use strict';

/**
 * @ngdoc function
 * @name cotizadorApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the cotizadorApp
 */
angular.module('FamsaPendings')
  .controller('MainCtrl', function ($scope, Pending, Type) {
	$scope.pendings =[];
    $scope.yeomanImg = ctxPath+"images/famsa.png";
    $scope.config = {
    	    itemsPerPage: 5,
    	    fillLastPage: true
    	  }
    
    $scope.loadTypes = function(){
    	Type.get({}).$promise.then(function(resp) {
    		$scope.types = resp.data;
    	});
    }
    $scope.loadPendings = function(idType){
    	$scope.filter = {};
    	if(idType)
    		$scope.filter = {'idType.id':idType};
    	Pending.get($scope.filter).$promise.then(function(resp) {
    		$scope.pendings = resp.data;
    	});
    }
    
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
    	            label: 'Si',
    	            className: 'btn-success'
    	        },
    	        cancel: {
    	            label: 'No',
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
  });
