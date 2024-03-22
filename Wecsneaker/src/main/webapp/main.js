/**
 * 
 */
function toast(
    title="",
    Message="",
    type="info",
    duration=1000)
    {
        const main=document.getElementById('toast');
        if(main)
        {
            const toast=document.createElement('div');
            setTimeout(function () {
             main.removeChild(toast);
             }, duration + 1000);
            toast.onclick=function(e){
                if(e.target.closest('.toast__close')){
                    main.removeChild(toast);
                }
            }
            const icons={
                success:'fa-check-circle',
                warning:'fa-exclamation-circle',
                infor:'fa-info-circle',
                error:'fa-exclamation-triangle',
            };
            const icon=icons[type]
            const delay = (duration / 1000).toFixed(2);
            toast.classList.add('toast',`toast--${type}`);
            toast.style.animation = `slideInLeft ease .3s, fadeOut linear 1s ${delay}s forwards`;
            toast.innerHTML=`<div class="toast__icon">
            <i class="fa ${icon}" aria-hidden="true"></i>
        </div>
        <div class="toast__body">
            <h3 class="toast__body__title">${title}</h3>
            <div class="toast__body__msg">
                ${Message}
            </div>
        </div>
        <div class="toast__close">
            <i class="fa fa-times" aria-hidden="true"></i>
        </div>`;
        main.appendChild(toast);
        }
    }
    function showSuccess(){
        toast(
        "favorites",
        "You have added the product to your favorites",
        "success",
         5000);
    }
    function showdeleteSuccess(){
        toast(
        "Delete Success",
        "You have delete the product in your favorites",
        "success",
         5000);
    }
    function showinfor(){
        toast(
        "Create Account",
        "Your Account has been successfully created",
        "infor",
         5000)
    }
    function showWarning(){
        toast(
        "Warning",
        "Please Input Your Information",
        "warning",
        5000)
    }
    function showWarningSelectSize(){
        toast(
        "Warning",
        "Please Select Size",
        "warning",
        5000)
    }
    function showWarningCart(){
        toast(
        "Warning",
        "Please add Product to cart",
        "warning",
        5000)
    }
    
    function showError(){
        toast(
        "Error",
        "Wrong account or password",
        "error",
        5000)
    }
    function showErrorSignUp(){
		toast(
        "Notification",
        "Your email or username has been registered",
        "error",
        5000)
	}
	 function showinforLogin(){
        toast(
        "Hello Friend",
        "Sign in before buy item",
        "infor",
         5000)
    }
     function showinforLoadCard(){
        toast(
        "Hello Friend",
        "Sign in before see bag",
        "infor",
         5000)
    }
     function showAddSuccess(){
        toast(
        "Add To Cart",
        "You have added the product to your Bag",
        "success",
         5000);
    }
    function showAddSuccessF(){
        toast(
        "Add To favourite",
        "You have added the product to your favourite",
        "success",
         5000);
    }
    function showinforLoginFavorite(){
        toast(
        "Hello Friend",
        "Sign in before see favourite",
        "infor",
         5000)
    }
    function showinforLoginFavorite2(){
        toast(
        "Hello Friend",
        "Sign in before add item to favourite",
        "infor",
         5000)
    }
function img(anything){
    const img=document.querySelector('.slide-img');
    img.src=anything;
}
const container=document.getElementById('container');
const btnRegister=document.getElementById('register');
const btnlogin=document.getElementById('login')
        btnRegister.addEventListener('click',()=>{
            container.classList.add('active')
        })
        btnlogin.addEventListener('click',()=>{
            container.classList.remove('active')
        })
function autoLoad(){
	container.classList.add('active')
}   
document.addEventListener('DOMContentLoaded', function () {
    const myFormSignin = document.getElementById('myformSignin');

    myFormSignin.addEventListener('submit', function (event) {
        const userName = document.getElementById('Username2').value;
        const passWord = document.getElementById('Password2').value;

        // Check if either the username or password is empty
        if (userName.trim().length === 0 || passWord.trim().length === 0) {
            event.preventDefault(); // Prevent the form from being submitted
            showWarning();
        }
})})
document.addEventListener('DOMContentLoaded', function () {
        const myFormSignup = document.getElementById('myformSignup');
    
        myFormSignup.addEventListener('submit', function (event) {
            const userName = document.getElementById('Username1').value;
            const email = document.getElementById('Email1').value;
            const FullName = document.getElementById('FullName1').value;
            const passWord = document.getElementById('Password1').value;
            const rePassword = document.getElementById('Repassword1').value;
    
            if (FullName.trim().length === 0 || userName.trim().length === 0 || passWord.trim().length === 0 || email.trim().length === 0 || rePassword.trim().length === 0) {
                event.preventDefault(); // Prevent the form from being submitted
                showWarning();
            } else if (passWord !== rePassword) {
                event.preventDefault(); // Prevent the form from being submitted
                showError(); // Show error for mismatched passwords
          }
        });
    });
    document.addEventListener('DOMContentLoaded',function(){
	   const myForm=document.getElementById('form-container');
	   myForm.addEventListener('submit',function(event){
		    var radioButtons = document.getElementsByName('selector');
         var isChecked = false;

         // Kiểm tra xem có radio button nào được chọn không
         for (var i = 0; i < radioButtons.length; i++) {
             if (radioButtons[i].checked) {
                 isChecked = true;
                 break;
             }
         }
         if(!isChecked){
				event.preventDefault();
				showWarningSelectSize()
			}
	   })
});
   function My_submit(){
        	var my_form=document.getElementById("myformSignup");
        	my_form.submit();
        }
         function addproduct() {
        const test = document.getElementById('test');
        test.style.display='flex'
      }
      function updateproduct() {
        const test = document.getElementById('test2');
        test.style.display='flex'
      }
      document.addEventListener('DOMContentLoaded', function () {
        const test = document.getElementById('test');
        const form=document.getElementById('main')
        test.addEventListener('click',function(event) {
            if (event.target === test) {
                test.style.display = 'none';
            }
            test.addEventListener('click')  
        })
      })

      document.addEventListener('DOMContentLoaded', function () {
        const test = document.getElementById('test2');
        const form=document.getElementById('main')
        test.addEventListener('click',function(event) {
            if (event.target === test) {
                test.style.display = 'none';
            }
            test.addEventListener('click')  
        })
      })
        