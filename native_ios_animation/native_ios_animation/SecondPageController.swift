//
//  SecondPageController.swift
//  native_ios_animation
//
//  Created by Andreas Biørn-Hansen on 11/11/2017.
//  Copyright © 2017 Andreas Biørn-Hansen. All rights reserved.
//

import Foundation

//
//  ViewController.swift
//  native_ios_animation
//
//  Created by Andreas Biørn-Hansen on 11/11/2017.
//  Copyright © 2017 Andreas Biørn-Hansen. All rights reserved.
//

import UIKit
import SideMenu

class SecondPageController: UIViewController {
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
       
        
        print(UINavigationControllerHideShowBarDuration);
        
        SideMenuManager.menuPresentMode = .menuSlideIn
        SideMenuManager.menuFadeStatusBar = false
        
    }
    
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    
}

