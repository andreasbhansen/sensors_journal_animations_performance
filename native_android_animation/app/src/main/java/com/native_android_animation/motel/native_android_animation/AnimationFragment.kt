package com.native_android_animation.motel.native_android_animation

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
//import android.app.Fragment
import android.support.v4.app.Fragment
import android.os.Debug
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.airbnb.lottie.LottieAnimationView
import kotlinx.android.synthetic.main.fragment_animation.view.*
import java.io.Console


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [AnimationFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [AnimationFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AnimationFragment : Fragment(), View.OnClickListener {

    private lateinit var animationView: LottieAnimationView

    private var mListener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater?.inflate(R.layout.fragment_animation, container, false);

        val playAnimationButton = view?.findViewById<Button>(R.id.btn_play_animation) as Button
        playAnimationButton.setOnClickListener(this)

        val navigateToSecondPageButton = view?.findViewById<Button>(R.id.btn_navigate_to_second_page) as Button
        navigateToSecondPageButton.setOnClickListener(this)

        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        animationView = getView()?.findViewById<View>(R.id.animation_view) as LottieAnimationView
        animationView.setAnimation("favourite_app_icon.json")
    }

    override fun onClick(v: View) {
        when (v.getId()) {
            R.id.btn_play_animation -> {
                animationView.playAnimation()
            }

            R.id.btn_navigate_to_second_page -> {
                val intent = Intent(activity, SecondPage::class.java)
                startActivity(intent)
                /*fragmentManager
                        .beginTransaction()
                        .replace(R.id.main_content_frame, SecondFragment::class.java.newInstance() as Fragment)
                        .commit()*/
            }
        }

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            mListener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        mListener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments](http://developer.android.com/training/basics/fragments/communicating.html) for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        // TODO: Rename parameter arguments, choose names that match

        // TODO: Rename and change types and number of parameters
        fun newInstance(param1: String, param2: String): AnimationFragment {
            val fragment = AnimationFragment()
            return fragment
        }
    }
}// Required empty public constructor
