/*
    Form category adding validator
*/
/*$(document).ready(function() {*/
        jQuery('#basicForm').bootstrapValidator({
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
            },
            fields: {
                 
            	newcategory: {
                    validators: {
                        notEmpty: {
                           message: 'News category is required'
                        },
            			stringLength: {
            				max: 50,
            				message: 'The news category must be less than 50 characters'
            			}
                    }
                },
                cate_desc: {
                    validators: {
                        notEmpty: {
                           message: 'Category description is required'
                        },
                        stringLength: {
            				max: 50,
            				message: 'The category description must be less than 20 characters'
            			}
                    }
                }
                
            }
            
            
        });
     