package com.urdhvam.appClass

import android.Manifest
import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.google.gson.Gson
import com.josh.roomlivedataviewmodel.customView.CustomProgressDialog
import com.urdhvam.network.ErrorResponse
import com.urdhvam.viewModel.BaseViewModel

abstract class BaseActivity : AppCompatActivity() {

    /**
     *  Base Spinner Dialog
     *  for all Api Calls
     */
    private var spinningDialog: Dialog? = null

    /**
     *  Base ViewModel Reference
     */
    protected lateinit var mViewModel: BaseViewModel

    protected var isDataBindingEnabbled: Boolean = false

    /**
     * This method will be the starting point in all the other activities.
     */
    abstract fun init()

    /**
     * Override for set view model
     * @return view model instance
     */
    abstract fun initializeViewModel()

    /**
     * This method is used to define layout id (Ex: R.layout.activity_login)
     */
    @LayoutRes
    abstract fun getLayoutId(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (!isDataBindingEnabbled) {
            setContentView(getLayoutId())
        }
        initializeViewModel()
        init()
    }

    /**
     * To load progress dialog on screen
     */
    fun showLoader() {
        try {
            if (spinningDialog == null) {
                spinningDialog = CustomProgressDialog.showProgressDialog(this@BaseActivity)
            }
            spinningDialog!!.setCancelable(false)
            spinningDialog!!.show()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    /**
     * To hide showing dialog
     */
    fun hideLoader() {
        spinningDialog?.let { if (it.isShowing) it.cancel() }
    }

    fun showToast(message: String?, duration: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, message, duration).show()
    }


    fun AppCompatActivity.addFragment(fragment: Fragment, frameId: Int) {
        supportFragmentManager.inTransaction { add(frameId, fragment) }
    }

    fun AppCompatActivity.replaceFragment(fragment: Fragment, frameId: Int) {
        supportFragmentManager.inTransaction { replace(frameId, fragment) }
    }

    inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) {
        beginTransaction().func().commit()
    }



    fun showSoftKeyboard(view: View) {
        if (view.requestFocus()) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
        }
    }

    fun hideSoftKeyboard(view: View) {
        var imm: InputMethodManager =
            (getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager)
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    fun showError(data: java.lang.Exception?) {
        data?.let {
            hideLoader()
            if ((it.message ?: "").equals("unauthorized")) {
                handleUserUnAuthorization()
            } else {
                it.message?.let {
                    val message: String =
                        Gson().fromJson<ErrorResponse>(it, ErrorResponse::class.java).message
                    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun handleUserUnAuthorization() {

    }


}
