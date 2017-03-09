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
	  .controller('MainCtrl', ['Pending','Type','UploadFile', MainCtrl]);
	
	/**
	 * @param Pending
	 * @param Type
	 * @returns
	 */
	function MainCtrl(Pending, Type, UploadFile) {
		var vm = this;
		vm.pendings = [];
	    vm.yeomanImg = ctxPath+"images/famsa.png";
	    vm.config = {
		    itemsPerPage: 5,
		    fillLastPage: true
		}
	    
	    vm.loadTypes = loadTypes;
	    vm.loadPendings = loadPendings;
	    vm.addType = addType;
	    vm.savePending = savePending;	    
	    vm.deletePending = deletePending;
	    
	    vm.editPending = function(item){
	    	if(item.idType && item.idType.id)
	    		item.idType.id +='';
	    	vm.pending = item;
	    }
	    console.debug(angular.identity)
	    vm.submitfile =  function submitfile(){
	    	UploadFile.save($("#uploadForm")).$promise.then(function(e){
	    		console.debug(e);
	    	})
//	    	console.log('do')
//	    	console.log($("#uploadForm"))
//		    var formdata = new FormData($("#uploadForm"));
//		    $.ajax({
//		        type: "POST",
//		        url: "http://localhost:8080/alfresco/service/api/upload?alf_ticket=TICKET_4f1b4dd7bdc76f254b2f534c1e00272d5193c493",
//		        data: formdata,
//		        processData: false,
//		        contentType: false,
//		        dataType: "json",
//		        success: function(data, textStatus, jqXHR) {
//		        	console.log(data)
//		        },
//		        error: function(data, textStatus, jqXHR) {
//		        	console.log(data)
//		           //process error msg
//		        },
//		    });
	    }
	    
	    /**
	     * 
	     */
	    function loadTypes(){
	    	console.debug('loadTypes -->')
	    	Type.get().$promise.then((types) => vm.types = types.data,console.debug('loadTypes ==>'));
	    	console.debug('loadTypes //>')
	    }
	   
	   /**
	    * 
	    */
	   function loadPendings(idType){
	    	vm.filter = idType?{'idType.id':idType}:{};
	    	Pending.get(vm.filter).$promise.then((resp)=>vm.pendings = resp.data);
	    }	    
	  }
		/**
		 * @returns
		 */
		function savePending(){
	    	if(vm.pending.title && vm.pending.title.trim().length >0){
		    	if(vm.pending.id){
		    		Pending.update(vm.pending).$promise.then((resp) => vm.pending = {},vm.loadPendings());
		    	}else{
		    		Pending.save(vm.pending).$promise.then((resp)=> vm.pending = {}, vm.loadPendings());    		
		    	}
	    	}
	    }
		/**
		 * @returns
		 */
		function addType(){
	    	bootbox.prompt("Escriba el nuevo tipo de pendientes", function(result){    		
	    		if(result && result.trim().length > 0){
	    			Type.save({type:result}, (resp)=> vm.loadTypes());
	    		}
	    	});
	    }
		/**
		 * @param item
		 * @returns
		 */
		function deletePending(item){
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
		    	       	Pending.drop(item).$promise.then((resp)=> vm.loadPendings());
	    	       }
	    	    }
	    	});
	    }
})();
