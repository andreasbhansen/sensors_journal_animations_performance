//
//  ViewController.swift
//  native_ios_animation
//
//  Created by Andreas Biørn-Hansen on 11/11/2017.
//  Copyright © 2017 Andreas Biørn-Hansen. All rights reserved.
//

import UIKit
import SideMenu
import Lottie

class ViewController: UIViewController {
    
    fileprivate var lottieAnimation: LOTAnimationView!
    fileprivate var animatedBox: UIView!

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        
        SideMenuManager.menuPresentMode = .menuSlideIn
        SideMenuManager.menuFadeStatusBar = false
        
        lottieAnimation = LOTAnimationView(name: "favourite_app_icon")
        lottieAnimation.contentMode = .scaleAspectFill
        lottieAnimation.heightAnchor.constraint(equalToConstant: 350).isActive = true
        lottieAnimation.widthAnchor.constraint(equalToConstant: 350).isActive = true

        
        // PLAY BUTTON:
        let playAnimationButton = UIButton(type: UIButtonType.roundedRect)
        playAnimationButton.setTitle("Play Animation", for: .normal)
        playAnimationButton.addTarget(self, action: #selector(self.playAnimation), for: .touchUpInside)
        
        
        // CUSTOM ANIMATION VIEW:
        /*animatedBox = UIView()
        animatedBox.backgroundColor = UIColor.red
        animatedBox.heightAnchor.constraint(equalToConstant: 200).isActive = true
        animatedBox.widthAnchor.constraint(equalToConstant: 200).isActive = true*/
        
        // STACK VIEW
        let stackView = UIStackView()
        stackView.axis = .vertical
        stackView.spacing = 5
        stackView.translatesAutoresizingMaskIntoConstraints = false
        stackView.addArrangedSubview(lottieAnimation)
        //stackView.addArrangedSubview(animatedBox)
        stackView.addArrangedSubview(playAnimationButton)
        self.view.addSubview(stackView)
        
        stackView.centerXAnchor.constraint(equalTo: self.view.centerXAnchor).isActive = true
        stackView.centerYAnchor.constraint(equalTo: self.view.centerYAnchor).isActive = true

    }
    
    override func viewDidAppear(_ animated: Bool) {
        super.viewDidAppear(animated)
    }
    
    @objc func playAnimation() {
        print("Starting animation")
        lottieAnimation.play()
        
        /*UIView.animate(withDuration:0.9, animations: {
            self.animatedBox.transform = CGAffineTransform(rotationAngle: CGFloat(Double.pi))
        })*/
    }
    
    @objc func goBack() {
    
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

