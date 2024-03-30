package org.LMS.interfaces.useCases;

import org.LMS.models.user.AuthorizationCredentials;
import org.LMS.models.user.User;

public interface IGetUserAuthorizationService {
   User execute(AuthorizationCredentials authorizationCredentials);
}
