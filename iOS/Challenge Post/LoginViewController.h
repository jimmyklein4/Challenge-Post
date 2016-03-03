//
//  ViewController.h
//  Challenge Post
//
//  Created by Jimmy Klein on 3/1/16.
//  Copyright © 2016 tudev. All rights reserved.
//

#import <UIKit/UIKit.h>

@class RegisterViewController;

@interface LoginViewController : UIViewController {
    IBOutlet RegisterViewController *registerViewController;
}
-(IBAction)register:(UIButton *)sender;
@property (nonatomic,retain) RegisterViewController *registerViewController;

@end

