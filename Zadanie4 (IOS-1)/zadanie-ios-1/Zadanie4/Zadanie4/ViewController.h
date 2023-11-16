//
//  ViewController.h
//  Zadanie4
//
//  Created by student on 09/11/2023.
//  Copyright © 2023 SystemyMobilne. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "SecondViewController.h"

@interface ViewController : UIViewController <SecondViewControllerDelegate>

@property (nonatomic, weak) IBOutlet UILabel *messageLabel;
@property (nonatomic, weak) IBOutlet UITextField *inputField;
@property (nonatomic, weak) IBOutlet UITextField *inputFieldSurname;
@end
