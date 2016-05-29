/*
    Form category adding validator
*/
/*$(document).ready(function() {*/
        jQuery('#useradd').bootstrapValidator({
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
            },
            fields: {
                 
                 username: {
                    validators: {
                        notEmpty: {
                           message: 'Username is required'
                        },
            			stringLength: {
            				max: 50,
            				message: 'The username must be less than 50 characters'
            			}
                    }
                },
              password: {
                    validators: {
                        notEmpty: {
                           message: 'Password is required'
                        },
                        stringLength: {
            				max: 20,
            				message: 'The password must be less than 20 characters'
            			}
                    }
                },
                repassword: {
                    validators: {
                        notEmpty: {
                           message: 'Repassword is required'
                        },
                identical: {
                    field: 'password',
                    message: 'The password and its confirm are not the same'
                }
                    }
                },
                usertype: {
                    validators: {
                        notEmpty: {
                           message: 'Usertype is required'
                        }
                    }
                }
                
            }
            
            
        });
     
       /*--------------Script for Validate show on the progress bar----------*/
        jQuery(document).ready(function () {
            "use strict";
            var options = {};
            options.ui = {
                container: "#pwd-container",
                showVerdictsInsideProgressBar: true,
                viewports: {
                    progress: ".pwstrength_viewport_progress"
                }
            };
            options.common = {
                debug: true,
                onLoad: function () {
                    $('#messages').text('Start typing password');
                }
            };
            $(':password').pwstrength(options);
        });
        
/*});*/