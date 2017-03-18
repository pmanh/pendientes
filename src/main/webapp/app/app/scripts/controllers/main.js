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
	    vm.savePending = sendForm;	    
	    vm.deletePending = deletePending;
	    
	    vm.editPending = function(item){
	    	if(item.idType && item.idType.id)
	    		item.idType.id +='';
	    	vm.pending = item;
	    }
	    
	    vm.submitfile =  function submitfile(event){
	    	
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
		function sendForm(){
			console.log("submiting file")
		    var formdata = new FormData(document.querySelector("form"));
			formdata.append("filename", $('#filedata')[0].files[0].name);
		    $.ajax({
		        type: "POST",
		        url: "http://localhost:8080/alfresco/service/api/upload?alf_ticket=TICKET_7d8cff3ed81a2ed8dfc7dda425cc7e1c3ecbb10f",
		        data: formdata,
		        processData: false,
		        contentType: false,
		        dataType: "json",
		        success: function(data, textStatus, jqXHR) {
		        	console.log(data)
		        	//Process data
//		        	savePending();
		        },
		        error: function(data, textStatus, jqXHR) {
		        	console.log(data)
		           //process error msg
		        },
		    });
		    
	    	
	    }
		
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
